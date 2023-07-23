import 'package:flutter/material.dart';

class ReturnDataScreen extends StatefulWidget {
  const ReturnDataScreen({Key? key}) : super(key: key);

  @override
  State<ReturnDataScreen> createState() => _ReturnDataScreenState();
}

class _ReturnDataScreenState extends State<ReturnDataScreen> {
  final _textController = TextEditingController();
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
            Padding(
              padding : const EdgeInsets.symmetric(horizontal: 16),
              child : TextField(
                controller: _textController,
                decoration: const InputDecoration(labelText: "Enter name"),
              )
            ),
            ElevatedButton(onPressed: (){
              Navigator.pop(context, _textController.text);
            }, child: const Text("Back"))
          ],
        ),
      ),
    );
  }
  @override
  void dispose() {
    _textController.dispose();
        super.dispose();
  }
}