package co.japo.layoutsapp;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by japodeveloper on 9/16/17.
 */

public class WebSiteRepository {

    public static List<WebModel> webs;

    static{
        webs = new ArrayList<>();
        webs.add( new WebModel(R.drawable.amazon,"Amazon"));
        webs.add(new WebModel(R.drawable.app_store,"App Store"));
        webs.add(new WebModel(R.drawable.dropbox,"Dropbox"));
        webs.add(new WebModel(R.drawable.evernote,"Evernote"));
        webs.add( new WebModel(R.drawable.facebook,"Facebook"));
        webs.add( new WebModel(R.drawable.github,"Github"));
        webs.add( new WebModel(R.drawable.google_drive,"Google Drive"));
        webs.add( new WebModel(R.drawable.google_plus,"Google Plus"));
        webs.add(new WebModel(R.drawable.instagram,"Instagram"));
        webs.add(new WebModel(R.drawable.itunnes,"itunnes"));
        webs.add(new WebModel(R.drawable.linkedin,"Linkedin"));
        webs.add(new WebModel(R.drawable.pinterest,"Pinterest"));
        webs.add(new WebModel(R.drawable.play_store,"Play Store"));
        webs.add(new WebModel(R.drawable.playstation,"Playstation"));
        webs.add( new WebModel(R.drawable.reddit,"Reddit"));
        webs.add( new WebModel(R.drawable.sound_cloud,"Sound cloud"));
        webs.add(new WebModel(R.drawable.stackoverflow,"Stack Overflow"));
        webs.add(new WebModel(R.drawable.steam,"Steam"));
        webs.add(new WebModel(R.drawable.twitter,"Twitter"));
        webs.add(new WebModel(R.drawable.whatsapp,"Whatsapp"));
        webs.add(new WebModel(R.drawable.wordpress,"Wordpress"));

    }
}
