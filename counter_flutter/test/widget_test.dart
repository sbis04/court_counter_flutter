import 'package:counter_flutter/main.dart';
import 'package:flutter/material.dart';
import 'package:flutter_test/flutter_test.dart';

void main() {
  Widget makeTestableWidget({Widget child}) {
    return MaterialApp(
      home: child,
    );
  }

  testWidgets('Splash screen test', (WidgetTester tester) async {
    SplashScreen splashScreen = SplashScreen();

    await tester.pumpWidget(makeTestableWidget(child: splashScreen));


    expect(find.text('Court Counter'), findsOneWidget);
    expect(find.byType(Image),findsOneWidget);


    print('Found app title text.');
    print('Found splash screen image.');
  });
}
