import 'dart:convert';

class Article {
  final String author;
  final String title;
  final String description;
  final String url;
  final String urlToImage;
  final String publishedAt;
  final String content;


  Article({
    required this.author,
    required this.title,
    required this.description,
    required this.url,
    required this.urlToImage,
    required this.publishedAt,
    required this.content,
  });

  factory Article.fromJson(Map<String, dynamic> jsonArticle) => Article(
          author: jsonArticle["author"], title: jsonArticle["title"],
          description: jsonArticle["description"], url: jsonArticle["url"],
          urlToImage: jsonArticle["urlToImage"], publishedAt: jsonArticle["publishedAt"], content: jsonArticle["content"]);


}

List<Article> parserArticles(String? json ) {
    if(json == null) {
      return [];
    }
    final List parsed = jsonDecode(json);
    return parsed.map((row) => Article.fromJson(row)).toList();
  }