import 'package:flutter/material.dart';
import 'package:flutter/material.dart';
import 'package:navigation_route/first_screen.dart';
import 'package:navigation_route/other_screen.dart';
import 'package:navigation_route/replacement_screen.dart';
import 'package:navigation_route/return_data_screen.dart';
import 'package:navigation_route/second_screen.dart';
import 'package:navigation_route/second_screen_with_data.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {

      return MaterialApp(
        title : "Sample",
        theme : ThemeData(
          primarySwatch: Colors.blue,
          visualDensity:  VisualDensity.adaptivePlatformDensity
        ),
        initialRoute: "/",
        routes: {
          "/" : (context) => const FirstScreen(),
          "/secondScreen": (context) => const SecondScreen(),
          "/secondScreenWithData" : (context) => SecondScreenWithData(
            ModalRoute.of(context)?.settings.arguments as String),
          "/returnDataScreen" : (context) => ReturnDataScreen(),
          "/replacementScreen" : (context) => const ReplacementScreen(),
          "/anotherScreen" : (context) => const AnotherScreen()
        },
      );
  }

}