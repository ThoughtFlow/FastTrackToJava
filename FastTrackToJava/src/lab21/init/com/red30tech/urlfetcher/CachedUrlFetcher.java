package lab21.init.com.red30tech.urlfetcher;

import lab21.init.com.red30tech.cache.Cache;
import lab21.init.com.red30tech.database.Database;
import lab21.init.com.red30tech.database.DatabaseFactory;
import lab21.init.com.red30tech.database.Durability;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CachedUrlFetcher implements UrlFetcher {

   private final Database database;

   public CachedUrlFetcher() {
     Database database = DatabaseFactory.getDatabase();

     try {
        database = new Cache(database);
        System.out.println("Using cache and database");
     }
     catch (NoClassDefFoundError exception) {
         // We'll just use the regular database
         System.out.println("Using database only");
     }

     this.database = database;
  }

   @Override
   public Stream<String> getPage(String url, Durability durability) {
     Stream<String> stream;

     if (database.get(url) == null) {
        try {
           stream = getReader(url).lines();
        } catch (IOException e) {
           stream = Stream.empty();
        }
        database.create(url, stream.collect(Collectors.toList()), durability);
     }

     List<String> list = (List<String>) (database.get(url));
     return list.stream();
   }

   private BufferedReader getReader(String stringedUrl) throws IOException {

      URL url = new URL(stringedUrl);
      return new BufferedReader(new InputStreamReader(url.openConnection().getInputStream()));
   }
}
