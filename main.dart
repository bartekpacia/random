import 'dart:io';

//create stream with numbers from 1 to 100, delayed by 10sec duration
Stream<int> countStream() async* {
  for (int i = 1; i <= 100; i++) {
    yield i;      
    print('before sleeping $i');
    sleep(Duration(seconds: 2));
  }
}

void main() async {
  var x = await countStream().firstWhere((element) => element == 1); //here Im waiting for number 1
  print(x);
}
