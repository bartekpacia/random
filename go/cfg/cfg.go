package cfg

type StatementType int

const (
	Simple StatementType = iota + 1
	ConditionalJump
	UnconditionalJump
)

type Statement interface {
	Type() StatementType
	Next() []int
}

type BasicBlock struct{}

func GetBasicBlocks(statements []Statement) []BasicBlock {
	// Step 1: determine the set of leaders
}
