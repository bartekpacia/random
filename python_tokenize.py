import tokenize
from io import BytesIO

code = """a = 1
if a:
  print('a is truthy')
  if a == 2:
    print('a is two')
print('done')"""

tokens = tokenize.tokenize(BytesIO(code.encode('utf-8')).readline)

for token in tokens:
    if token.type != tokenize.ENCODING and token.type != tokenize.ENDMARKER:
        print(f"TokenInfo({tokenize.tok_name[token.type]}, string='{token.string}', line={token.start[0]})")
