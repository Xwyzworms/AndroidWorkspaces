
import 'package:submission_1/presentation/enums.dart';

class Animal
{
  String name;
  String description;
  AnimType type;
  Family family;
  int lifeSpan;
  String imageAssetPath;
  List<String> imageAssetsUrl;

  Animal({
    required String this.name,
    required String this.description,
    required AnimType this.type,
    required Family this.family,
    required int this.lifeSpan,
    required String this.imageAssetPath,
    required List<String> this.imageAssetsUrl
  });
}