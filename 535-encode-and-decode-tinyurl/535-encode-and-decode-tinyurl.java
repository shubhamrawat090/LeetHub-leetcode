public class Codec {
    int key = 1;
    HashMap<Integer,String> map = new HashMap<>();
    
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        map.put(key,longUrl);
        key++;
        return Integer.toString(key-1);
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        int tmp = Integer.parseInt(shortUrl);
        return map.get(tmp);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));