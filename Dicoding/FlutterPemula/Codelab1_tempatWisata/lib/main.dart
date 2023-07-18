import 'package:codelab1_tempat_wisata/presentation/detail_screen/DetailScreen.dart';
import 'package:codelab1_tempat_wisata/presentation/main_screen/MainScreen.dart';
import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context)
  {
    return MaterialApp(
      title : "Wisata Bandoeng",
      theme : ThemeData(),
      home: MainScreen(),
    );
  }
}
