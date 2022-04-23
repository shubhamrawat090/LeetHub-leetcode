public class Codec {
    int key = 1;//act as short url
    HashMap<Integer,String> map = new HashMap<>();//stores shortURL->longURL pair
    
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        //store key as the short URL(it can be anything according to the hashing function implemented, here it is just integer)
        map.put(key,longUrl); 
        key++;//increment the key to get a new key
        return Integer.toString(key-1);//return that previous key where the longURL was stored in map
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        //convert the shortURL to integer as the key is in int format
        int tmp = Integer.parseInt(shortUrl);
        return map.get(tmp);//get the longURL corresponding to the key
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));