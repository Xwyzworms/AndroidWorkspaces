import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
        theme: ThemeData(primarySwatch: Colors.blue), home: HomePage());
  }
}

class HomePage extends StatefulWidget {
  const HomePage({super.key});

  @override
  _HomePageState createState() => _HomePageState();
}

class _HomePageState extends State<HomePage> {
  int numTaps = 0;
  int doubleTaps = 0;
  int numLongPress = 0;

  final double boxSize = 150.5;

  double posX = 0.0;
  double posY = 0.0;
  void center(BuildContext context) {
    posX = (MediaQuery.of(context).size.width / 2) - boxSize / 2;
    posY = (MediaQuery.of(context).size.height / 2) - boxSize;


    setState(() {
      this.posX = posX;
      this.posY = posY;
    });
  }

  @override
  Widget build(BuildContext context) {
    if(posX == 0) {
      center(context);
    }
    return Scaffold(
      appBar: AppBar(title: const Text("Gesture Detector")),
      body: Stack(children: [
        Positioned(
            left : this.posX,
            top : this.posY,
            child: GestureDetector(
                onTap: () {
                  setState(() {
                    numTaps += 1;
                  });
                },
                onDoubleTap: () {
                  setState(() {
                    doubleTaps += 1;
                  });
                },
                onLongPress: () {
                  setState(() {
                    numLongPress += 1;
                  });
                },
                onPanUpdate: (DragUpdateDetails details)
                {
                  setState(() {
                    double deltaY = details.delta.dy;
                    double deltaX = details.delta.dx;
                    posX += deltaX;
                    posY += deltaY;
                  });
                },
                child: Container(
                  width: boxSize,
                  height: boxSize,
                  decoration: const BoxDecoration(color: Colors.blue),
                )))
      ]),
      bottomNavigationBar: Container(
        color: Colors.yellow,
        padding: const EdgeInsets.all(16.0),
        child: Text(
          "Taps : $numTaps - Double Taps : $doubleTaps - Long Press: $numLongPress ",
          style: Theme.of(context).textTheme.headline6,
        ),
      ),
    );
  }
}
