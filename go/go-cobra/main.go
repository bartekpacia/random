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
		if len(args) != 0 {
			// Enforce only a single completion result.
			// The default "cobra.ShellCompDirectiveDefault" causes files to be suggested.
			// Use "cobra.ShellCompDirectiveNoFileComp" to stop suggestions after completion is accepted.
			return []string{}, cobra.ShellCompDirectiveNoFileComp
		}

		cobra.CompDebugln(fmt.Sprintf("args: %#v", args), true)
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

var createCmd = &cobra.Command{
	Use:   "create",
	Short: "Create a new device",
	Run: func(cmd *cobra.Command, args []string) {
		fmt.Printf("create called with args: %#v\n", args)
	},
}

func init() {
	rootCmd.AddCommand(runCmd)
	rootCmd.CompletionOptions.HiddenDefaultCmd = false // If false, the 'completion' command is shown in completions

	rootCmd.AddCommand(runAllCmd)

	rootCmd.AddCommand(killCmd)
	killCmd.Flags().StringVar(&killDevice, "device", "", "The device to kill")
	_ = killCmd.MarkFlagRequired("device")
	_ = killCmd.RegisterFlagCompletionFunc("device",
		func(cmd *cobra.Command, args []string, toComplete string) ([]string, cobra.ShellCompDirective) {
			cobra.CompDebug(fmt.Sprintf("args: %v, toComplete: %s\n", args, toComplete), false)

			// Use "cobra.ShellCompDirectiveDefault" to see files being suggested.
			return devices, cobra.ShellCompDirectiveNoFileComp
		},
	)

	rootCmd.AddCommand(createCmd)
	createCmd.Flags().SortFlags = false
	createCmd.Flags().String("os", "", "OS of the device")
	_ = createCmd.MarkFlagRequired("os")
	_ = createCmd.RegisterFlagCompletionFunc("os",
		func(cmd *cobra.Command, args []string, toComplete string) ([]string, cobra.ShellCompDirective) {
			completions := []string{"Android", "iOS"}
			if len(args) != 0 {
				clear(completions)
			}
			return completions, cobra.ShellCompDirectiveNoFileComp
		},
	)

	createCmd.Flags().String("os-version", "", "OS image version")
	_ = createCmd.MarkFlagRequired("os-version")
	_ = createCmd.RegisterFlagCompletionFunc("os-version",
		func(cmd *cobra.Command, args []string, toComplete string) ([]string, cobra.ShellCompDirective) {
			androidCompletions := []string{"Android 14 (API 33)", "Android 14 (API 33) Play Store", "Android 15 (API 34)"}
			iosCompletions := []string{"iOS 15", "iOS 16", "iOS 17"}

			completions := make([]string, 0)
			if cmd.Flag("os").Value.String() == "Android" {
				completions = androidCompletions
			} else if cmd.Flag("os").Value.String() == "iOS" {
				completions = iosCompletions
			}

			if len(args) != 0 {
				clear(completions)
			}

			return completions, cobra.ShellCompDirectiveNoFileComp
		},
	)

	createCmd.Flags().String("frame", "", "Frame of the device")
	_ = createCmd.MarkFlagRequired("frame")
	_ = createCmd.RegisterFlagCompletionFunc("frame",
		func(cmd *cobra.Command, args []string, toComplete string) ([]string, cobra.ShellCompDirective) {
			androidCompletions := []string{"Pixel 6", "Pixel 6a", "Pixel 7", "Pixel 7 XL"}
			iosCompletions := []string{"iPhone 12", "iPhone 12 mini", "iPhone 12 Pro", "iPhone 12 Pro Max", "iPhone 13", "iPhone 13 Pro", "iPhone 13 Pro Max"}

			completions := make([]string, 0)
			if cmd.Flag("os").Value.String() == "Android" {
				completions = androidCompletions
			} else if cmd.Flag("os").Value.String() == "iOS" {
				completions = iosCompletions
			}

			if len(args) != 0 {
				clear(completions)
			}

			return completions, cobra.ShellCompDirectiveNoFileComp
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
