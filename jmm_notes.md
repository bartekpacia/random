ExpressionStatement
		MethodCallExpression (name: setA, jmm.type: JmmType{name='int'})
   			VariableLiteral (name: sf, jmm.type: JmmClassType{name='Structure_fields', superClass=JmmClassType{name='java.lang.Object', superClass=null}})
   			IntegerLiteral (jmm.type: JmmType{name='int'}, value: 25)

ExpressionStmt
		IdUseExpr (name: setA)
				Identifier (id: sf)
				IntegerLiteral (value: 25)



- - -

t2.i32 :=.i32 invokevirtual(sf.Structure_fields, "setA", 25.i32).i32;


tmp1.i32 := .i32 invokevirtual(sf.Structure_fields, "setA", 25.i32).i32;
tmp1.i32;

---

int setA(int value) {
		a = value;
		return 0;
}


.method setA(value.i32).i32 {
		putfield(this.Structure_fields, a.i32, $1.value.i32).V;
		ret.i32 0.i32;
}

.method a().i32 {
ret.i32 a.i32;
}


---

GenericMethodDeclaration (isStatic: false, methodName: setA, isPublic: false, jmm.type: JmmType{name='int'})
	  Type (name: int, isArray: false)
	  ParameterDeclaration (name: value)
	     Type (name: int, isArray: false)
	  VariableAssignmentStatement (name: a, jmm.type: JmmType{name='int'})
	     VariableLiteral (name: value, jmm.type: JmmType{name='int'})
	  IntegerLiteral (jmm.type: JmmType{name='int'}, value: 0)

Method (isStatic: false, name: setA, isPublic: false)
   Type (name: int, isArray: false, isVarArg: false)
   Param (name: value)
      Type (name: int, isArray: false, isVarArg: false)
   AssignStmt (id: a)
      Identifier (id: value)
   ReturnStmt
      IntegerLiteral (value: 0)
