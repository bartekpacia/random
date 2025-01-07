import 'dart:io' as io;
import 'dart:isolate';

void main(List<String> args) {
  final sw = Stopwatch()..start();
  final String arg = args.first;

  if (arg == "future") {
    Stopwatch()..start();
    _longWork();
    print("started long work: future");
  } else if (arg == "isolate_run") {
    Isolate.run(_longWork);
    print("started long work: isolate_run");
  } else if (arg == "isolate_spawn") {
    Isolate.spawn((message) => _longWork(), null);
    print("started long work: isolate_spawn_closure");
  } else if (arg == "isolate_spawn_closure") {
    final int closedOver = 2137;
    final void Function(int?) closure = (int? _) {
      print('I captured int: $closedOver');
    };
    Isolate.spawn(closure, null);
    print("started long work: isolate_spawn_closure");
  } else {
    print('error: unknown argument');
    io.exit(1);
  }

  final time = sw.elapsed.inMilliseconds;
  print('Total time: $time');
}

Future<void> _longWork() async {
  await Future.delayed(const Duration(seconds: 3));
}
