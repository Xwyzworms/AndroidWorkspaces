import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:submission_1/presentation/detail/widgets/FavoriteButton.dart';
import 'package:submission_1/presentation/detail/widgets/FavoriteButtonState.dart';
import 'package:submission_1/presentation/models/animals.dart';

import '../models/Animal.dart';

class DetailScreen extends StatelessWidget {
  final Animal anim;
  const DetailScreen({Key? key, required this.anim}) : super(key: key);
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: SingleChildScrollView( child : Column(
        children: [
          Stack(children: [
            Image.asset(anim.imageAssetPath),
            SafeArea(
                child: Container(
                    margin: const EdgeInsets.only(left: 10),
                    decoration: BoxDecoration(
                      borderRadius: BorderRadius.circular(100),
                      color: Colors.black54.withOpacity(0.7),
                    ),
                    child: IconButton(
                      icon: const Icon(Icons.arrow_back),
                      onPressed: () {
                        Navigator.pop(context);
                      },
                        color: Colors.white,
                    ))),
            Positioned(
                left: 15,
                bottom: 10,
                child: Container(
                  alignment: AlignmentDirectional.center,
                  decoration: BoxDecoration(
                    borderRadius: BorderRadius.circular(15),
                    color: Colors.black54.withOpacity(0.6),
                  ),
                  padding: const EdgeInsets.all(10),
                  child: Text(
                    anim.name,
                    style: TextStyle(
                        color: Colors.white.withOpacity(0.9), fontSize: 30),
                  ),
                ))
          ]),
          Row(mainAxisAlignment: MainAxisAlignment.spaceAround, children: [
            Container(
                padding: const EdgeInsets.symmetric(vertical: 10),
                child: Column(
                  children: [
                    const Icon(Icons.forest_outlined),
                    const SizedBox(height: 4.0),
                    Text("Hewan : ${anim.type.name}")
                  ],
                )),
            Container(
                padding: const EdgeInsets.symmetric(vertical: 10),
                child: Column(
              children: [
                const Icon(Icons.view_agenda_outlined),
                const SizedBox(height: 4.0),
                Text("Famili : ${anim.family.name}")
              ],
            )),
          ]),
          Padding(
              padding: const EdgeInsets.symmetric(horizontal: 20, vertical: 10),
              child: Text(
                anim.description,
                textAlign: TextAlign.justify,
              )),
          Container(
            margin: const EdgeInsets.all(10),
            child: const Text("Pictures of the Animals"),
          ),
          SizedBox(
              height: 150,
              child: ListView(
                scrollDirection: Axis.horizontal,
                children: anim.imageAssetsUrl.map((animPath) {
                  return Padding(
                    padding: const EdgeInsets.all(4),
                    child: ClipRRect(
                      borderRadius: BorderRadius.circular(10),
                      child: Image.asset(animPath),
                    ),
                  );
                }).toList(),
              ))
          // View the coressponding Dogs
        ],
      ),
      ),
      floatingActionButton: FloatingActionButton(
        backgroundColor: Colors.black54,
          onPressed: () {  },
          child: FavoriteButton()),
    );
  }
}
