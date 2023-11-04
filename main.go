package main

import (
	"net/http"
	"fmt"
	"slices"
)

var originAllowList = []string{
	"http://127.0.0.1:9999",
}

func checkCORS(next http.Handler) http.Handler {
	return http.HandlerFunc(func (w http.ResponseWriter, r *http.Request) {
		origin := r.Header.Get("Origin")
		if slices.Contains(originAllowList, origin) {
			w.Header().Set("Access-Control-Allow-Origin", origin)
			w.Header().Add("Vary", "Origin")
		}
		next.ServeHTTP(w, r)
	})
}

func isPreflight(r *http.Request) bool {
  return r.Method == "OPTIONS" &&
    r.Header.Get("Origin") != "" &&
    r.Header.Get("Access-Control-Request-Method") != ""
}

func apiHandler(w http.ResponseWriter, r *http.Request) {
	w.Header().Set("Content-Type", "application/json")
	fmt.Fprintln(w, `{"message": "hello"}`)
}

func main() {
	port := ":8080"
	mux := http.NewServeMux()
	mux.HandleFunc("/api", apiHandler)
	http.ListenAndServe(port, checkCORS(mux))
}
