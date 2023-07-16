

import 'package:equatable/equatable.dart';
import 'package:qoute_app_flutter/domain/entities/AdviceEntity.dart';

class AdviceModel extends AdviceEntity with EquatableMixin {

  AdviceModel({required int id, required String advice}) : super(id : id, advice: advice);

  factory AdviceModel.fromJson(Map<String, dynamic> json) {
    return AdviceModel(id: json["advice_id"], advice: json["advice"]);
  }
}