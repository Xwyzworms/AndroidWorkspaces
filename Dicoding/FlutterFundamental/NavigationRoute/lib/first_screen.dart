import 'package:flutter/material.dart';

class FirstScreen extends StatelessWidget {
  const FirstScreen({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Navigation & Routing'),
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
            ElevatedButton(
              child: const Text('Go to Second Screen'),
              onPressed: () {
                Navigator.pushNamed(context, "/secondScreen");
              },
            ),
            ElevatedButton(
              child: const Text('Navigation with Data'),
              onPressed: () {
                Navigator.pushNamed(context, "/secondScreenWithData", arguments: "Block");
              },
            ),
            ElevatedButton(
              child: const Text('Return Data from Another Screen'),
              onPressed: () async {
                final scaffoldManager = ScaffoldMessenger.of(context);
                final result = await Navigator.pushNamed(context, "/returnDataScreen");
                SnackBar snackBar = SnackBar(content: Text(result.toString()));
                scaffoldManager.showSnackBar(snackBar);

              },
            ),
            ElevatedButton(
              child: const Text('Replace Screen'),
              onPressed: () {
                Navigator.pushNamed(context,"/replacementScreen");
              },
            ),
          ],
        ),
      ),
    );
  }
}