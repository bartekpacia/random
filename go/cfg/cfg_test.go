package cfg_test

import (
	"testing"
)

type stmt struct {
	stmtType StatementType
	next     []int
}

func (s stmt) Type() StatementType {
	return s.stmtType
}

// Next returns indices of the next instruction.
//
// If this is a conditonal jump, the second element is the index of the instruction
// that will be executed if the condition is true.
func (s stmt) Next() []int {
	return s.next
}

func TestGetBasicBlocks_Simple(t *testing.T) {
	program := map[int]stmt{
		0: {
			stmtType: Simple,
			next:     []int{1},
		},
		1: {
			stmtType: ConditionalJump,
			next:     []int{2, 3},
		},
		2: {
			stmtType: UnconditionalJump,
			next:     []int{5},
		},
		3: {
			stmtType: Simple,
			next:     []int{4},
		},
		4: {
			stmtType: UnconditionalJump,
			next:     []int{1},
		},
		5: {
			stmtType: Simple,
			next:     []int{},
		},
	}

	statements := make([]Statement, len(program))
	for i, s := range program {
		statements[i] = s
	}

	basicBlocks := GetBasicBlocks(statements)
}
