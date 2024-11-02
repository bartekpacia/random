package main

import (
	"fmt"
	"sync"
	"time"
)

var logs = []string{
	"INFO: a random log line",
	"INFO: another completely random log line",
	"DEBUG: aaand yet another one",
	"ERROR: some random error",
	"INFO: bruh this is boring and so random",
	"INFO: a random log line",
	"INFO: please be creative, chatgpt",
	"INFO: come on",
	"INFO: I believe in you",
	"INFO: a random log line",
	"INFO: another completely random log line",
	"DEBUG: aaand yet another one",
	"ERROR: some random error",
	"INFO: bruh this is boring and so random",
	"INFO: a random log line",
	"INFO: please be creative, chatgpt",
	"INFO: you can do better",
	"INFO: come on",
}

var defaultFrames = []rune{
	'⠋',
	'⠙',
	'⠹',
	'⠸',
	'⠼',
	'⠴',
	'⠦',
	'⠧',
	'⠇',
	'⠏',
}

func main() {
	wg := sync.WaitGroup{}

	wg.Add(1)
	go func() {
		for _, log := range logs {
			time.Sleep(1 * time.Second)
			fmt.Printf("\r%s\n", log)
		}
		wg.Done()
	}()

	wg.Add(1)
	go func() {
		for i := 0; i <= 100; i++ {
			frame := defaultFrames[i%len(defaultFrames)]
			time.Sleep(100 * time.Millisecond)
			fmt.Printf("\r%c Progress: %d %%", frame, i)
		}
		wg.Done()
	}()

	wg.Wait()

	fmt.Println("done")
}
