//https://howtodoinjava.com/java/io/java-read-file-to-string-examples/

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParse {

    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then read link upto next )
        int currentIndex = 0;
        while(currentIndex < markdown.length()) {
            int openBracket = markdown.indexOf("[", currentIndex);
            int closeBracket = markdown.indexOf("]", openBracket);
            int openParen = markdown.indexOf("(", closeBracket);
            int closeParen = markdown.indexOf(")", openParen);

            int nextOpenBracket = markdown.indexOf("[", closeParen);
                if(nextOpenBracket!=-1){
                    for(int i = closeParen; i<nextOpenBracket;i++){
                    if(markdown.indexOf(")", closeParen)==-1){
                        continue;
                    }else{
                        if(markdown.indexOf(")", closeParen + 1) != -1 &&markdown.indexOf(")", closeParen + 1)<nextOpenBracket){
                            closeParen = markdown.indexOf(")", closeParen + 1);
                        }
                    }
                }
                }else{
                    for(int i = closeParen; i<markdown.length();i++){
                if(markdown.indexOf(")", closeParen)==-1){
                    continue;
                }else{
                    if (markdown.indexOf(")", closeParen + 1) != -1){
                        closeParen = markdown.indexOf(")", closeParen + 1);
                    }
                }
            }
        }

            toReturn.add(markdown.substring(openParen + 1, closeParen));
            currentIndex = closeParen + 1;



        }
        

        return toReturn;
    }


    public static void main(String[] args) throws IOException {
        Path fileName = Path.of(args[0]);
        String content = Files.readString(fileName);
        ArrayList<String> links = getLinks(content);
	    System.out.println(links);
    }
}



/** 
    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then read link upto next )
        int currentIndex = 0;
        while(currentIndex < markdown.length()) {
            //need All "[", "]",and"(",")", if cannot find correct, stop.
            //1. find "[". if no, stop. Else, continue.
            if(markdown.indexOf("[", currentIndex)==-1){
                break;
            }else{
                int openBracket = markdown.indexOf("[", currentIndex);
                //2. find "]", if no, stop
                if(markdown.indexOf("]", openBracket)==-1){
                    break;
                }else{
                    int closeBracket = markdown.indexOf("]", openBracket);
                    if(markdown.indexOf("(", closeBracket)==-1){
                        break;
                    }else{
                        int openParen = markdown.indexOf("(", closeBracket);
                        if(markdown.indexOf(")", openParen)==-1){
                            break;
                        }else{
                            int closeParen = markdown.indexOf(")", openParen);
                            toReturn.add(markdown.substring(openParen + 1, closeParen));
                            currentIndex = closeParen + 1;
                        }
                    }
                }
            }
        }
        
*/