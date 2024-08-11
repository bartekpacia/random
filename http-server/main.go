package main

import (
	"fmt"
	"net/http"
	"net/http/httputil"
)

func main() {
	http.HandleFunc("/", func(w http.ResponseWriter, r *http.Request) {
		fmt.Println("---> New Request <---")
		reqBytes, _ := httputil.DumpRequest(r, true)
		fmt.Print(string(reqBytes))

		w.WriteHeader(http.StatusOK)
		w.Write([]byte("Hello, World!\n"))
	})

	http.ListenAndServe("localhost:2137", nil)
}
