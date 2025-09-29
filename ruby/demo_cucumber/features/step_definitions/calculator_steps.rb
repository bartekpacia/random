class Calculator
  def add(a, b)
    a + b
  end
end

Given("I have entered {int} into the calculator") do |n|
  @inputs ||= []
  @inputs << n
end

When("I press add") do
  calc = Calculator.new
  @result = calc.add(@inputs[0], @inputs[1])
end

Then("the result should be {int} on the screen") do |expected|
  expect(@result).to eq(expected)
end
