
import 'package:flutter/material.dart';
import 'package:news_app/DetailPage.dart';

import 'article.dart';

class NewsListPage extends StatelessWidget {
  static String routeName = "newsList";
  const NewsListPage({super.key});


  @override
  Widget build(BuildContext context)
  {

    return Scaffold(
      appBar : AppBar(
        title : const Text("News App"),
      ),
      body : FutureBuilder<String>(
        future : DefaultAssetBundle.of(context).loadString("assets/articles.json"),
        builder : (context, snapshot) {
          final List<Article> articles = parserArticles(snapshot.data);
          return ListView.builder(
              itemCount: articles.length,
              itemBuilder: (context, index) {
                return _buildArticleItem(context, articles[index]);
              });
        }
      )

    );

  }

  Widget _buildArticleItem(BuildContext context, Article article) {
    return ListTile(
      contentPadding: const EdgeInsets.symmetric(horizontal: 16.0, vertical: 8.0),
      leading : Image.network(article.urlToImage, width: 100, errorBuilder: (ctx, error, _) => const Center(child: Icon(Icons.error))),
      title : Text(article.title),
      subtitle: Text(article.author),
      onTap: () {
          Navigator.pushNamed(context,
              DetailPage.routeName,
              arguments: article);
      },
    );
  }
}