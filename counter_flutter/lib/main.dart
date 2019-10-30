import 'dart:ui';

import 'package:flutter/material.dart';

void main() => runApp(chooseWidget(window.defaultRouteName));

Widget chooseWidget(String route) {
  switch(route) {
    case 'splashRoute':
      return MyFlutterView();

    default:
      return Center(
        child: Text('Unkown'),
      );
  }
}

class MyFlutterView extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      home: SplashScreen(),
    );
  }
}

class SplashScreen extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Container(
        child: FlutterLogo(
          size: 200,
        ),
      ),
    );
  }
}



