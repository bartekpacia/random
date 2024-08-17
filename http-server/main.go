package main

import (
	"fmt"
	"time"
	"net/http"
	"net/http/httputil"
)

const addr = "localhost:2137"

func main() {
	http.HandleFunc("/", func(w http.ResponseWriter, r *http.Request) {
		fmt.Println("---> New Request <---")
		reqBytes, _ := httputil.DumpRequest(r, true)
		fmt.Print(string(reqBytes))

		w.WriteHeader(http.StatusOK)

		data := fmt.Sprintln("Hello, World! Current time is", time.Now().Format(time.RFC850)) 
		w.Write([]byte(data))
	})

	fmt.Println("will listen on", addr)
	http.ListenAndServe(addr, nil)
}
