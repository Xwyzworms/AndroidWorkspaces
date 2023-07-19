import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

class ProfileMain extends StatelessWidget {
  const ProfileMain({Key? key}) : super(key: key);
  final TextStyle defaultTextTheme = const TextStyle(color: Colors.white);
  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(title: const Text("Hi There")),
        body: SingleChildScrollView(
            child: Container(
                padding: const EdgeInsets.all(10),
                height: 500,
                child: Card(
                  color: const Color.fromARGB(255, 32, 36, 42),
                  child: Container(
                    padding: const EdgeInsets.all(25),
                    child: Column(
                      crossAxisAlignment: CrossAxisAlignment.start,
                      children: [
                        Row(
                            mainAxisAlignment: MainAxisAlignment.spaceBetween,
                            children: [
                              Container(
                                  margin: const EdgeInsets.only(right: 15),
                                  child: ClipRRect(
                                      borderRadius: BorderRadius.circular(100),
                                      child: Image.asset(
                                        "images/anjing.jpg",
                                        height: 100,
                                        width: 100,
                                        fit: BoxFit.cover,
                                      ))),
                              const Expanded(
                                  flex: 2,
                                  child: Column(
                                    crossAxisAlignment:
                                        CrossAxisAlignment.start,
                                    children: [
                                      Text(
                                        "XoRose",
                                        style: TextStyle(
                                            fontSize: 20, color: Colors.white),
                                      ),
                                      Text("Zhongshan East, Shanghai, China",
                                          style: TextStyle(
                                              fontSize: 13,
                                              color: Colors.white))
                                    ],
                                  ))
                            ]),
                        Container(
                            margin: const EdgeInsets.symmetric(vertical: 20),
                            child: const Row(
                                mainAxisAlignment:
                                    MainAxisAlignment.spaceEvenly,
                                children: [
                                  Column(children: [
                                    Text("Following",
                                        style: TextStyle(
                                          color: Colors.grey,
                                          fontSize: 18,
                                        )),
                                    Divider(
                                      height: 10,
                                      thickness: 3,
                                    ),
                                    Text("-1",
                                        style: TextStyle(
                                            color: Colors.white, fontSize: 18))
                                  ]),
                                  Column(
                                    children: [
                                      Text(
                                        "Followers",
                                        style: TextStyle(
                                          color: Colors.grey,
                                          fontSize: 18,
                                        ),
                                      ),
                                      Divider(
                                        height: 10,
                                        thickness: 3,
                                      ),
                                      Text("-1",
                                          style: TextStyle(
                                              color: Colors.white,
                                              fontSize: 18))
                                    ],
                                  )
                                ])),
                        const Text("Skills : ",
                            style:
                                TextStyle(color: Colors.white, fontSize: 24)),
                        Expanded(
                            child: ClipRRect(
                                borderRadius: BorderRadius.circular(10),
                                child: Container(
                                    color: Colors.white,
                                    child: Container(
                                        width: double.infinity,
                                        child: const Column(
                                            mainAxisAlignment:
                                                MainAxisAlignment.center,
                                            children: [
                                              Text(
                                                  "You don't have Any Skills yet",
                                                  textAlign: TextAlign.center,
                                                  style: TextStyle(
                                                      fontStyle:
                                                          FontStyle.italic))
                                            ]))))),
                        Container(
                            width: double.infinity,
                            child: ElevatedButton(
                                onPressed: () {}, child: Text("Open Settings")))
                      ],
                    ),
                  ),
                ))));
  }
}
