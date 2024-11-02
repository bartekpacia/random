package main

type Progress struct{}

func NewProgress(message string) *Progress {
	return &Progress{}
}

// Complete ends the progress and marks it as a successful completion.
func (p *Progress) Complete() {
}

// Fail ends the progress and marks it as failed.
func (p *Progress) Fail() {
}

func (p *Progress) Update(message string) {
}
