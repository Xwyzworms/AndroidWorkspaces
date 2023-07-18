
import 'package:codelab1_tempat_wisata/presentation/detail_screen/FavoriteButton.dart';
import 'package:codelab1_tempat_wisata/presentation/model/tourism.dart';
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter/rendering.dart';

class DetailScreen extends StatelessWidget {
  final TourismPlace place;
  const DetailScreen({Key? key, required this.place}) : super(key:key);

  @override
  Widget build(BuildContext context)
  {
    const defaultTextStyle = TextStyle(fontFamily: "rubik");
    return Scaffold(
        body : SafeArea (
            child: SingleChildScrollView(
                child: Column(
                  crossAxisAlignment: CrossAxisAlignment.stretch,
                  children: <Widget>[
                    Stack(children: [
                      Image.asset(place.imageAsset),
                      SafeArea(
                          child: Padding(padding: const EdgeInsets.all(10),
                              child : Row( mainAxisAlignment: MainAxisAlignment.spaceBetween,
                                children : [
                                  CircleAvatar(
                                      backgroundColor: Colors.grey,
                                      child: IconButton(icon: const Icon(Icons.arrow_back, color: Colors.white,), onPressed: () {
                                        Navigator.pop(context);
                                      })
                                  ),
                                FavoriteButton()],
                              )
                          )
                      )
                    ]),
                    Container(
                      margin : const EdgeInsets.only(top:16.0),
                      child : Text(place.name,
                          textAlign: TextAlign.center,
                          style : const TextStyle(
                              fontSize: 30.0,
                              fontWeight: FontWeight.bold,
                              fontFamily: 'Staatliches'
                          )
                      ),

                    ),
                    Container(
                        margin : const EdgeInsets.symmetric(vertical: 16.0),
                        child : Row(
                          mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                          children: <Widget>[
                            Column(children:<Widget>[
                              const Icon(Icons.calendar_today),
                              const SizedBox(height: 8.0),
                              Text(place.openDays,style: defaultTextStyle,)
                            ],),
                            Column(children:<Widget>[
                              const Icon(Icons.lock_clock),
                              const SizedBox(height: 8.0),
                              Text(place.openTime, style: defaultTextStyle,)
                            ]),
                            Column(children:<Widget>[
                              const Icon(Icons.monetization_on_outlined),
                              const SizedBox(height: 8.0),
                              Text(place.ticketPrice, style : defaultTextStyle)
                            ])
                          ],
                        )
                    ),
                    Container(
                      padding : const EdgeInsets.all(16.0),
                      child: Text(place.description,
                          textAlign: TextAlign.center,
                          style : const TextStyle(fontSize: 16.0)
                      ),
                    ),
                    SizedBox( height: 150,
                        child: ListView(
                          scrollDirection: Axis.horizontal,
                          children:  place.imageUrls.map((url){
                            return Padding(
                              padding : const EdgeInsets.all(4.0),
                              child: ClipRRect(
                                  borderRadius : BorderRadius.circular(10),
                                  child : Image.network(url)
                              ),
                            );
                          }).toList(),
                        )
                    )
                  ],
                )
            )
        )
    );
  }

}