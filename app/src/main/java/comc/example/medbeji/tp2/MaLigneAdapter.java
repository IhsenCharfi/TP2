package comc.example.medbeji.tp2;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * Created by medbeji on 28/02/2017.
 */

class ViewHolder {
    TextView label;
    ImageView icone;
}


public class MaLigneAdapter extends ArrayAdapter {

    Context context ;
    String[] items ;
    MaLigneAdapter(Context context , String[] items ) {
        super(context,R.layout.ma_ligne,items);
        this.context = context;
        this.items = items ;

    }

    public View getView(int position, View convertView , ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        ViewHolder holde;

        if(convertView == null) {
            convertView = inflater.inflate(R.layout.ma_ligne, parent, false);

            holde = new ViewHolder();
            holde.label= (TextView) convertView.findViewById(R.id.note);
            holde.icone = ( ImageView ) convertView.findViewById(R.id.monImage);

            convertView.setTag(holde);
        }else{
            holde = (ViewHolder)convertView.getTag();
        }


        float note = Float.valueOf(items[position]);
        holde.label.setText(items[position]);
        holde.icone.setImageResource(
                    (note >=10)? R.drawable.happy : R.drawable.sad);
        return convertView;
    }


}
