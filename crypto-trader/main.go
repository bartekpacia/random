package main

import (
	"context"
	"crypto/ecdsa"
	"fmt"
	"log"
	"math/big"
	"os"

	"github.com/ethereum/go-ethereum/common"
	"github.com/ethereum/go-ethereum/core/types"
	"github.com/ethereum/go-ethereum/crypto"
	"github.com/ethereum/go-ethereum/ethclient"
	"github.com/joho/godotenv"
)

func main() {
	if err := run(); err != nil {
		log.Fatal(err)
	}
}

func run() error {
	if err := godotenv.Load(); err != nil {
		log.Println("Warning: .env file not found, using environment variables")
	}

	rpcURL := os.Getenv("RPC_URL")
	if rpcURL == "" {
		rpcURL = "https://rpc.sepolia.org"
	}

	privateKeyHex := os.Getenv("PRIVATE_KEY")
	if privateKeyHex == "" {
		return fmt.Errorf("PRIVATE_KEY environment variable is required")
	}

	if len(os.Args) < 3 {
		return fmt.Errorf("usage: %s <recipient_address> <amount_in_eth>", os.Args[0])
	}

	recipientAddr := os.Args[1]
	amountStr := os.Args[2]

	if !common.IsHexAddress(recipientAddr) {
		return fmt.Errorf("invalid recipient address: %s", recipientAddr)
	}
	recipient := common.HexToAddress(recipientAddr)

	amount, ok := new(big.Float).SetString(amountStr)
	if !ok {
		return fmt.Errorf("invalid amount: %s", amountStr)
	}

	// Convert ETH to Wei (1 ETH = 10^18 Wei)
	weiPerEth := new(big.Float).SetInt(big.NewInt(1e18))
	amountWei := new(big.Float).Mul(amount, weiPerEth)
	amountWeiInt, _ := amountWei.Int(nil)

	// Connect to Ethereum node
	client, err := ethclient.Dial(rpcURL)
	if err != nil {
		return fmt.Errorf("failed to connect to Ethereum node: %w", err)
	}
	defer client.Close()

	// Parse private key
	privateKey, err := crypto.HexToECDSA(privateKeyHex)
	if err != nil {
		return fmt.Errorf("failed to parse private key: %w", err)
	}

	publicKey := privateKey.Public()
	publicKeyECDSA, ok := publicKey.(*ecdsa.PublicKey)
	if !ok {
		return fmt.Errorf("failed to get public key")
	}
	fromAddress := crypto.PubkeyToAddress(*publicKeyECDSA)

	fmt.Printf("Sender:    %s\n", fromAddress.Hex())
	fmt.Printf("Recipient: %s\n", recipient.Hex())
	fmt.Printf("Amount:    %s ETH\n", amountStr)

	// Get nonce
	nonce, err := client.PendingNonceAt(context.Background(), fromAddress)
	if err != nil {
		return fmt.Errorf("failed to get nonce: %w", err)
	}

	// Get gas price
	gasPrice, err := client.SuggestGasPrice(context.Background())
	if err != nil {
		return fmt.Errorf("failed to get gas price: %w", err)
	}

	// Create transaction
	gasLimit := uint64(21000) // standard ETH transfer gas limit
	tx := types.NewTransaction(nonce, recipient, amountWeiInt, gasLimit, gasPrice, nil)

	// Get chain ID for signing
	chainID, err := client.NetworkID(context.Background())
	if err != nil {
		return fmt.Errorf("failed to get chain ID: %w", err)
	}

	// Sign transaction
	signedTx, err := types.SignTx(tx, types.NewEIP155Signer(chainID), privateKey)
	if err != nil {
		return fmt.Errorf("failed to sign transaction: %w", err)
	}

	// Send transaction
	err = client.SendTransaction(context.Background(), signedTx)
	if err != nil {
		return fmt.Errorf("failed to send transaction: %w", err)
	}

	txHash := signedTx.Hash().Hex()
	fmt.Printf("\nTransaction sent!\n")
	fmt.Printf("Hash: %s\n", txHash)
	fmt.Printf("View: https://sepolia.etherscan.io/tx/%s\n", txHash)

	return nil
}
