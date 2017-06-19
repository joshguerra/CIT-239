
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;

/**
 *
 * @author Josh
 */
class Term {
    private String word;
    private String definition;
    void setWord(String w) { word = w; }
    void setDefinition(String d) { definition = d; }
    public String getWord() {return word;}
    public String getDefinition() {return definition;} 
    
    // ListView calls toString() internally to display objects
    @Override
    public String toString() {
        return word;
    }
    
    Term(String w, String d) {
        setWord(w);
        setDefinition(d);
    }
}
