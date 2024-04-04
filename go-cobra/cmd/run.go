package cmd

import (
	"fmt"
	"slices"

	"github.com/spf13/cobra"
	"github.com/spf13/pflag"
)

var runCmd = &cobra.Command{
	Use:   "run",
	Short: "Run app on device",
	Run: func(cmd *cobra.Command, args []string) {
		fmt.Println("run called")
	},
	ValidArgsFunction: func(cmd *cobra.Command, args []string, toComplete string) ([]string, cobra.ShellCompDirective) {
		completions := []string{"app1", "app2"}

		msg := fmt.Sprintf("args: %v, toComplete: %s\n", args, toComplete)
		cobra.CompDebug(msg, false)

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

	runCmd.Flags().AddFlag(&pflag.Flag{
		Name:  "device",
		Usage: "Select device to run on",
	})

	runCmd.MarkFlagRequired("device")

	runCmd.RegisterFlagCompletionFunc(
		"device",
		func(cmd *cobra.Command, args []string, toComplete string) ([]string, cobra.ShellCompDirective) {
			return []string{"emulator-5554", "Barteks-iPhone"}, cobra.ShellCompDirectiveNoFileComp
		},
	)
}
