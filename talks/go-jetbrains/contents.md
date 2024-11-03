# Intro

I started programming in Go in 2020. It's my favorite programming language.

I never did anything professionally in it, although I'd love to.

I think of this talk as a lightning talk, where I'll share my thoughts on Go and
hopefully spark some interesting discussions.

# About Go

Released publicly on November 10, 2009; almost 15 years ago.

Created by 3 people at Google: Robert Griesemer, Rob Pike, Ken Thompson.

They were tired of writing Java and C++ at huge scale.

They decided to create a new programming language that would make their lives.
They decided that for a feature to be included in Go, the whole trio has to
agree.

> "The key point here is our programmers... They’re not capable of understanding
> a brilliant language... So, the language that we give them has to be easy for
> them to understand"
> 
> - Rob Pike

# Features of Go

- C-style syntax, statically typed, memory-safe
- Compiles fast to native code (with embedded runtime), garbage-collected
- Seamless cross-compliation
- Methods, interfaces, generics
- Strong, stable standard library (batteries-included)
- Strong tooling (go fmt, go vet, go test, go mod)
- Goroutines
- Compatibility promise
  - it's delightful not to have to worry about new Go releases breaking your
    project.
- Generics (reified)

## Missing features of Go

Perhaps what's omitted is more interesting than what's included.

- Classes, inheritance, constructors
- Exceptions
- No bounds on generics
- Annotations
- Syntax sugar "Just write the thing" (in the one true, simple, straighforward
  way)
- Functional programming (filter, map)

### No ternary

https://go.dev/doc/faq#Does_Go_have_a_ternary_form

## Concurrency

Goroutines are lightweight threads. Similar to Kotlin Coroutines, or Java's
virtual threads.

They appeared in 2009 though, significantly earlier than Kotlin/Java
equivalents. It was quite a novel idea, and Go was the first language to
popularize it in the industry.

## Tooling

Very toolable language.

Easy to parse in a single pass.

Everything is in the `go` command.

## go fmt

It formats code. No options.

There's also gofumpt which I personally prefer. It's gofmt but even stricter and
more opinionated.

## go build

Builds the project.

No Gradle, no Maven. Just `go build` and be done with it.

Exposes some basic configuration options.

Of coures, build process gets more complex if you use Cgo (but "Cgo is not Go",
and it's very frowned upon unless absolutely necessary).

## go test

No need to decide on JUnit 3/4/5, AssertJ, kotlinx.test, kotest, power-assert.

Just write the test for factorial:

```go
package factorial_test

import "factorial"

func TestFactorial(t *testing.T) {
    got := fact.Factorial(5)
    want := 120
    if got != 1 {
        t.Errorf("got = %q, want = %q", got, want)
    }
}
```

## other

Go compiler is implemented in Go.

Things that may be of interest to us:
- [package `ast`](https://pkg.go.dev/go/ast), for working with Go code as an AST


# Philosophy

What I find quite fascinating about Go is the philosophy that permeates the
community.

The philosophy of preferring simple over complex/bloated solution. It's also
expressed in its compatibility guarantee.

I'd consider it an offspring of the Unix philosophy.

An effect of this is that there's no dominant framework in Go, like there's
Spring in Java. When you ask about what framework to use, most people will tell
you "just stick to stdlib".

Honestly, Go is much closer to fulfilling [The Zen of
Python](https://peps.python.org/pep-0020) than Python itself.

There's also an unofficial [The Zen of
Go](https://dave.cheney.net/2020/02/23/the-zen-of-go).

## Simplicity

Keep things simple.

There is a strong drive in the Go community towards broadly defined
"simplicity".

Examples include:

## The Go Memory model

[The Go Memory Model](https://go.dev/ref/mem)

> If you must read the rest of this document to understand the behavior of your
> program, you are being too clever.
>
> Don't be clever.

github.com/robpike/filter

An apply/map/reduce module written by one of the creators of Go. He says in
readme:

>I wanted to see how hard it was to implement this sort of thing in Go, with as
>nice an API as I could manage. It wasn't hard.
>
>Having written it a couple of years ago, I haven't had occasion to use it once.
>Instead, I just use "for" loops.
>
>You shouldn't use it either.

# Criticism

Ignores 40 years of language design

- no enums
- no switch expressions
- no immutability

2 absolutely great blogposts that point out weaknesses of Go, and argue that its
"simplicity" mantra is a lie.

- https://fasterthanli.me/articles/i-want-off-mr-golangs-wild-ride
- https://fasterthanli.me/articles/lies-we-tell-ourselves-to-keep-using-golang


## Data Race Patterns in Go

[Data Race Patterns in Go](https://www.uber.com/en-NL/blog/data-race-patterns-in-go)

## HackerNews

If you're into reading a good ol' flamewars, just google "hackernews golang".

People always argue. I love it! So many different viewpoints.

## My opinion

I like Go. I like that it has the answers (or at least pretends to).

https://youtu.be/187trX0mo1o?t=175

# The end

I hope you found this talk interesting.

I also hope I convinced you to give Go a try. If I sparked your interest, you
might appreciate some additional resources to read/watch:

- [The Tour of Go](https://go.dev/tour)
- [Go FAQ](https://go.dev/doc/faq)
- [Go for Java programmers](https://go.dev/talks/2015/go-for-java-programmers.slide)
- [Russ Cox about Go interfaces](https://research.swtch.com/interfaces)
- [Google Go style guide](https://google.github.io/styleguide/go)
- Dave Cheney's blog
