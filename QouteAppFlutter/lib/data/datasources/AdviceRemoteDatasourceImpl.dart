import 'dart:convert';

import 'package:flutter/cupertino.dart';
import 'package:http/http.dart' as http;
import 'package:qoute_app_flutter/data/models/AdviceModel.dart';

import 'AdviceRemoteDatasource.dart';

class AdviceRemoteDatasourceImpl extends AdviceRemoteDatasource {

  final httpClient = http.Client();

  @override
  Future<AdviceModel> getRandomAdviceFromApi() async {
      final http.Response apiResponse = await httpClient.get(Uri.parse("https://api.flutter-community.com/api/v1/advice"),
      headers : {
        'content-type' : 'application/json'
      });
      if(apiResponse.statusCode != 200 )
      {
        throw Exception();
      }
      else {
        final  apiBody  = json.decode(apiResponse.body);
        return AdviceModel.fromJson(apiBody);
      }
  }

}