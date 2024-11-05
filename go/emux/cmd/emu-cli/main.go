package main

import (
	"context"
	"fmt"
	"log"
	"os"

	"github.com/urfave/cli/v3"
)

var devices = []string{"Pixel 7 API 34", "iPhone 12 mini", "iPhone 15"}

func main() {
	root := &cli.Command{
		Name:                  "emu",
		Usage:                 "Manage android emulators with ease",
		EnableShellCompletion: true,
		HideHelpCommand:       true,
		Flags: []cli.Flag{
			&cli.BoolFlag{
				Name:    "quiet",
				Aliases: []string{"q"},
				Usage:   "do not print invocations of subprocesses",
				Action: func(ctx context.Context, c *cli.Command, value bool) error {
					return nil
				},
			},
		},
		Commands: []*cli.Command{
			&runCmd,
			&runAllCmd,
			&killCmd,
			&createCmd,
		},
		CommandNotFound: func(ctx context.Context, c *cli.Command, command string) {
			log.Printf("invalid command '%s'", command)
		},
	}

	err := root.Run(context.Background(), os.Args)
	if err != nil {
		log.Fatalln(err)
	}
}

func action(ctx context.Context, c *cli.Command) error {
	fmt.Printf("command %#v called with args: %#v\n", c.Name, c.Args().Slice())
	return nil
}

var runCmd = cli.Command{
	Name:   "run",
	Usage:  "Start a single device",
	Action: action,
	Flags: []cli.Flag{
		&cli.BoolFlag{
			Name:  "fast",
			Usage: "Run device quickly",
		},
		&cli.BoolFlag{
			Name:  "slow",
			Usage: "Don't hurry up too much",
		},
	},
	ShellComplete: func(ctx context.Context, cmd *cli.Command) {
		for _, device := range devices {
			fmt.Println(device)
		}
	},
}

// TODO: Not expressible in urfave/cli
var runAllCmd = cli.Command{
	Name:   "runall",
	Usage:  "Start many devices",
	Action: action,
	ShellComplete: func(ctx context.Context, cmd *cli.Command) {
		for _, device := range devices {
			fmt.Println(device)
		}
	},
}

// TODO: Not expressible in urfave/cli
var killCmd = cli.Command{
	Name:   "kill",
	Usage:  "Kill a single device",
	Action: action,
	ShellComplete: func(ctx context.Context, cmd *cli.Command) {
		for _, device := range devices {
			fmt.Println(device)
		}
	},
}

var createCmd = cli.Command{
	Name:   "create",
	Usage:  "Create a new device",
	Action: action,
	Flags: []cli.Flag{
		&cli.StringFlag{
			Name:  "os",
			Usage: "OS of the device",
			// TODO: func ShellComplete
		},
		&cli.StringFlag{
			Name:  "os-version",
			Usage: "OS image version",
			// TODO: func ShellComplete
		},
		&cli.StringFlag{
			Name:  "frame",
			Usage: "Frame of the device",
			// TODO: func ShellComplete
		},
	},
	ShellComplete: func(ctx context.Context, cmd *cli.Command) {
		androidCompletions := []string{"Android 14 (API 33)", "Android 14 (API 33) Play Store", "Android 15 (API 34)"}
		iosCompletions := []string{"iOS 15", "iOS 16", "iOS 17"}

		completions := make([]string, 0)
		completions = append(completions, androidCompletions...)
		completions = append(completions, iosCompletions...)
	},
}
