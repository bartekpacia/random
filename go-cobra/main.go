package main

import (
	"fmt"
	"os"
	"slices"

	"github.com/spf13/cobra"
)

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

var runCmd = &cobra.Command{
	Use:   "run",
	Short: "Run app on device",
	Run: func(cmd *cobra.Command, args []string) {
		fmt.Println("run called")
	},
	ValidArgsFunction: func(cmd *cobra.Command, args []string, toComplete string) ([]string, cobra.ShellCompDirective) {
		completions := []string{"app1", "app2", "app3"}
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

func init() {
	rootCmd.AddCommand(runCmd)

	runCmd.Flags().String("device", "", "Select device to run on")

	runCmd.RegisterFlagCompletionFunc(
		"device",
		func(cmd *cobra.Command, args []string, toComplete string) ([]string, cobra.ShellCompDirective) {
			cobra.CompDebug(fmt.Sprintf("args: %v, toComplete: %s\n", args, toComplete), false)

			return []string{"emulator-5554", "Barteks-iPhone"}, cobra.ShellCompDirectiveNoFileComp
		},
	)
}
