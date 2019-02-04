package org.rash.drools;

import org.drools.compiler.compiler.DroolsParserException;
import org.drools.core.RuleBase;
import org.drools.core.WorkingMemory;
import org.rash.drools.model.playlist.Artist;
import org.rash.drools.model.playlist.PlayList;
import org.rash.drools.model.playlist.Song;

import java.io.IOException;

public class PlayListRules {
    public static void main(String[] args) throws IOException, DroolsParserException {
        MyRuleBase myRuleBase = new MyRuleBase();
        RuleBase ruleBase = myRuleBase.readRuleBase("playlist.drl");
        WorkingMemory workingMemory = ruleBase.newStatefulSession();
        Artist farhan = new Artist("Farhan", "Akthar");
        Artist mohit = new Artist("Mohit", "Chauhan");
        Artist arjit = new Artist("Arjith", "Singh");
        Artist arman = new Artist("Arman", "Malik");
        Artist sonu = new Artist("Sonu", "Nigam");

        Song rockon = new Song("Rock On!!", Song.Genre.ROCK, 351);
        rockon.addArtist(farhan);
        Song senorita = new Song("senorita", Song.Genre.POP, 349);
        senorita.addArtist(farhan);
        senorita.addArtist(arman);
        Song sochahai=new Song("Socha Hai", Song.Genre.JAZZ,406);
        sochahai.addArtist(farhan);
        sochahai.addArtist(sonu);

        PlayList farhanPlayList=new PlayList("farhan");
        farhanPlayList.addSong(rockon);
        farhanPlayList.addSong(senorita);
        farhanPlayList.addSong(sochahai);


        PlayList arjitPlaylist=new PlayList("Arjit");
        arjitPlaylist.addSong(sochahai);

        System.out.println("All are validations");
        workingMemory.insert(farhan);
        workingMemory.insert(arman);
        workingMemory.insert(sonu);
        workingMemory.insert(rockon);
        workingMemory.insert(senorita);
        workingMemory.insert(sochahai);
        workingMemory.insert(farhanPlayList);
        workingMemory.insert(arjitPlaylist);
        workingMemory.fireAllRules();

        System.out.println("Add Enrichment");
    }

    private static PlayList createFarhanPlaylist(Artist farhan, Artist arman, Artist sonu) {
        Song rockon = new Song("Rock On!!", Song.Genre.ROCK, 351);
        rockon.addArtist(farhan);
        Song senorita = new Song("senorita", Song.Genre.POP, 349);
        senorita.addArtist(farhan);
        senorita.addArtist(arman);
        Song sochahai=new Song("Socha Hai", Song.Genre.JAZZ,406);
        sochahai.addArtist(farhan);
        sochahai.addArtist(sonu);

        PlayList farhanPlayList=new PlayList("farhan");
        farhanPlayList.addSong(rockon);
        farhanPlayList.addSong(senorita);
        farhanPlayList.addSong(sochahai);

        return  farhanPlayList;
    }
}
