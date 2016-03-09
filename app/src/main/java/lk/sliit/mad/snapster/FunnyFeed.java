package lk.sliit.mad.snapster;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class FunnyFeed extends AppCompatActivity {
    String [] titles;
    String [] descriptions;
    int[] images = {R.drawable.kendall, R.drawable.yuri, R.drawable.tiffany, R.drawable.jessica};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_funny_feed);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Resources res = getResources();
        //get titles and descriptions from strings.xml
        titles = res.getStringArray(R.array.titles);
        descriptions = res.getStringArray(R.array.descriptions);
        //link listview
        ListView listView = (ListView) findViewById(R.id.listViewFunny);

        FunnyAdapter adapter = new FunnyAdapter(this, titles, images, descriptions);
        listView.setAdapter(adapter);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent funnyHOF = new Intent(getBaseContext(), FunnyHOF.class);
                startActivity(funnyHOF);
            }
        });
    }

}

class FunnyAdapter extends ArrayAdapter<String>
{
    Context context;
    int images[];
    String[] titles;
    String[] descriptions;
    FunnyAdapter(Context c, String[] titles, int imgs[], String[] descriptions)
    {
        super(c, R.layout.single_row_funny, R.id.textView4, titles);
        this.context = c;
        this.images = imgs;
        this.titles = titles;
        this.descriptions = descriptions;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflator = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflator.inflate(R.layout.single_row_funny, parent, false);
        ImageView imageview = (ImageView) row.findViewById(R.id.imageView2);
        TextView txt1 = (TextView) row.findViewById(R.id.textView4);
        TextView txt2 = (TextView) row.findViewById(R.id.textView5);

        imageview.setImageResource(images[position]);
        txt1.setText(titles[position]);
        txt2.setText(descriptions[position]);
        return row;
    }
}