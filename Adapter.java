package co.shrey.fireapp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by shrey on 04-06-2018.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>{

    List<UserInformation> list;
    public Adapter(List<UserInformation> list)
    {
        this.list=list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_item_layout , parent , false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {


        holder.txtname.setText( list.get(position).getName());
        holder.txtaddress.setText( list.get(position).getAddress());
        holder.txtage.setText( list.get(position).getAge());

    }

    @Override
    public int getItemCount() {
        return list.size() ;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView txtname;
        TextView txtaddress;
        TextView txtage;
        public ViewHolder(View itemView) {
            super(itemView);
            txtname = (TextView) itemView.findViewById(R.id.name);
            txtaddress = (TextView) itemView.findViewById(R.id.address);
            txtage = (TextView) itemView.findViewById(R.id.age);
        }
    }
}
