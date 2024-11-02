package main

import (
	"errors"
	"fmt"
	"os"
	"slices"

	"github.com/spf13/cobra"
)

var devices = []string{"Pixel 7 API 34", "iPhone 12 mini", "iPhone 15"}

var killDevice string

var runCmd = &cobra.Command{
	Use:   "run",
	Short: "Start a single device",
	Run: func(cmd *cobra.Command, args []string) {
		fmt.Printf("run called with args: %#v\n", args)
	},
	ValidArgsFunction: func(cmd *cobra.Command, args []string, toComplete string) ([]string, cobra.ShellCompDirective) {
		// Use "cobra.ShellCompDirectiveDefault" to see files being suggested. EDIT: Not true.
		// Use "cobra.ShellCompDirectiveNoFileComp" to stop suggestions after completion is accepted.
		return devices, cobra.ShellCompDirectiveDefault
	},
}

var runAllCmd = &cobra.Command{
	Use:   "runall",
	Short: "Start many devices",
	Run: func(cmd *cobra.Command, args []string) {
		fmt.Printf("run called with args: %#v\n", args)
	},
	ValidArgsFunction: func(cmd *cobra.Command, args []string, toComplete string) ([]string, cobra.ShellCompDirective) {
		completions := make([]string, len(devices))
		copy(completions, devices)
		for _, arg := range args {
			for i, completion := range completions {
				if arg == completion {
					completions = slices.Delete(completions, i, i+1)
				}
			}
		}

		return completions, cobra.ShellCompDirectiveNoFileComp
	},
}

// This command doesn't accept the device to kill through argument, but through option/flag
var killCmd = &cobra.Command{
	Use:   "kill",
	Short: "Kill a single device",
	RunE: func(cmd *cobra.Command, args []string) error {
		if killDevice == "" {
			return errors.New("required flag 'device' not set")
		}
		fmt.Printf("kill called with value: %#v\n", killDevice)
		return nil
	},
	//ValidArgsFunction: func(cmd *cobra.Command, args []string, toComplete string) ([]string, cobra.ShellCompDirective) {
	//	completions := []string{"app1", "app2", "app3"}
	//	for _, arg := range args {
	//		for i, completion := range completions {
	//			if arg == completion {
	//				completions = slices.Delete(completions, i, i+1)
	//			}
	//		}
	//	}
	//
	//	// Use "cobra.ShellCompDirectiveDefault" to see files being suggested.
	//	return completions, cobra.ShellCompDirectiveNoFileComp
	//},
}

func init() {
	rootCmd.AddCommand(runCmd)
	rootCmd.CompletionOptions.HiddenDefaultCmd = true

	rootCmd.AddCommand(runAllCmd)

	rootCmd.AddCommand(killCmd)
	killCmd.Flags().StringVar(&killDevice, "device", "", "The device to kill")
	_ = killCmd.MarkFlagRequired("device")
	_ = killCmd.RegisterFlagCompletionFunc(
		"device",
		func(cmd *cobra.Command, args []string, toComplete string) ([]string, cobra.ShellCompDirective) {
			cobra.CompDebug(fmt.Sprintf("args: %v, toComplete: %s\n", args, toComplete), false)

			// Use "cobra.ShellCompDirectiveDefault" to see files being suggested.
			return devices, cobra.ShellCompDirectiveNoFileComp
		},
	)
}

func main() {
	err := rootCmd.Execute()
	if err != nil {
		os.Exit(1)
	}
}

var rootCmd = &cobra.Command{
	Use:               "go-cobra",
	Short:             "A brief description of your application",
	ValidArgsFunction: cobra.NoFileCompletions,
}
