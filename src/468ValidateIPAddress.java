// all implementation, not much to see here:
class Solution {
    public String validIPAddress(String IP) {
        if(isValidIPv4(IP)) return "IPv4";
        else if(isValidIPv6(IP)) return "IPv6";
        else return "Neither";
    }
    
    public boolean isValidIPv4(String ip) {
        // if(ip.charAt(0)=='.') return false; // not needed since first empty part will not be ommitted
        if(ip.indexOf(".") == -1) return false;
        if(ip.charAt(ip.length() - 1) == '.') return false; // but last split empty part will be ommitted
        String[] tokens = ip.split("\\."); // need to escape this since split is taking a regex
        if(tokens.length != 4) return false;
        for(String token : tokens) if(!isValidIPv4Token(token)) return false;
        return true;
    }
    
    public boolean isValidIPv4Token(String token) {
        if(token.length() == 0) return false;
        if(token.startsWith("0") && token.length() > 1) return false;
        for(char c : token.toCharArray()) if(!Character.isDigit(c)) return false;
        try {
            int parsedInt = Integer.parseInt(token);
            if(parsedInt<0 || parsedInt>255) return false;
        } catch(NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public boolean isValidIPv6(String ip) {
        if(ip.indexOf(":") == -1) return false;
        // if(ip.charAt(0)==':') return false; // not needed since first empty part will not be ommitted
        if(ip.charAt(ip.length() - 1) == ':') return false; // but last split empty part will be ommitted
        String[] tokens = ip.split(":");
        if(tokens.length != 8) return false;
        for(String token: tokens) if(!isValidIPv6Token(token)) return false;
        return true;
    }
    
    public boolean isValidIPv6Token(String token) {
        if(token.length()>4 || token.length()==0) return false;
        char[] chars = token.toCharArray();
        for(char c:chars) {
            boolean isDigit = c >= '0' && c <= '9';
            boolean isUppercaseAF = c >= 'A' && c <= 'F';
            boolean isLowerCaseAF = c >= 'a' && c <= 'f';
            if(!(isDigit || isUppercaseAF || isLowerCaseAF)) return false;
        }
        return true;
    }
}