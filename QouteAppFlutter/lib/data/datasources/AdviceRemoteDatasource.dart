

import '../models/AdviceModel.dart';

abstract class AdviceRemoteDatasource {

  Future<AdviceModel> getRandomAdviceFromApi();
}