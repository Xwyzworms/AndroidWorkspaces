import 'package:flutter/material.dart';
import 'package:submission_1/presentation/home/HomeMain.dart';
import 'package:submission_1/presentation/profile/ProfileMain.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
      return MaterialApp(
        theme : ThemeData(),
        home : const HomeMain(),
      );
  }
}