
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:submission_1/presentation/detail/DetailScreen.dart';
import 'package:submission_1/presentation/models/animals.dart';
import 'package:submission_1/presentation/profile/ProfileMain.dart';

import '../models/Animal.dart';

class HomeMain extends StatelessWidget {

  const  HomeMain({Key? key}) : super(key:key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title : Text("Cats & Others"),
      actions: [
        IconButton(onPressed: (){
          Navigator.push(context, MaterialPageRoute(builder: (context) {
            return const ProfileMain();
          }));
        }, icon: const Icon(Icons.person))
      ],),
      body: ListView.builder(itemBuilder: (context , index){
      final Animal animal = animals[index];
        return InkWell( onTap: () {
          Navigator.push(context, MaterialPageRoute(builder: (context) {
            return DetailScreen(anim: animal);
          }));
        }, child: Padding ( padding : EdgeInsets.symmetric(vertical: 5),child:Row(
          children: [
            Expanded(flex : 1, child: Image.asset(animal.imageAssetPath)),
            Expanded(flex : 2,child: Column(
              children: [
                Text(animal.name),
                Text(animal.type.name)
              ],
            ),)
          ],
        )))
        ;
      },itemCount: animals.length),
    );
  }

}