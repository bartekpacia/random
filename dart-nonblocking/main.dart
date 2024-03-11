import 'dart:async';
import 'dart:isolate';
import 'dart:io' as io;

void main(List<String> args) {
	final sw = Stopwatch()..start();
	final String arg = args.first;

	if (arg == "future") {
		final sw = Stopwatch()..start();
		unawaited(_longWork());
		print("started long work");
	} else if (arg == "isolate") {
		// unawaited(Isolate.run(_longWork));
    Isolate.spawn((message) {
      _longWork();
    }, null);
		print("started long work in isolate");
	} else {
		print('pas either "future" or "isolate" as an argument');
		io.exit(1);
	}

	final time = sw.elapsed.inMilliseconds;
	print('Total time: $time');
}

Future <void> _longWork() async {
	await Future.delayed(const Duration(seconds: 3));
}
