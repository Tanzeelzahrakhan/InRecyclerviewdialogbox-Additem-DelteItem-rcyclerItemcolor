package com.example.recyclerviewindetail;

import static android.graphics.Color.parseColor;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MyDramasAdapter extends RecyclerView.Adapter<MyDramasAdapter.ViewHolder> {
  /*  private final MyDramasData[] myDramasData;
    MyDramasAdapter[] myDramasAdapters;*/
    ArrayList<MyDramasData>List;
    Context context;

    public MyDramasAdapter(ArrayList<MyDramasData> list, MainActivity activity) {
        this.List = list;
        this.context = activity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.recycler_item_design, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {

        MyDramasData myDramasList = List.get(position);
        //MyDramasData myDramasData=new MyDramasData(position);
        holder.textViewName.setText(myDramasList.getDramasName());
        holder.textViewDate.setText(myDramasList.getDramasData());
        holder.dramasImage.setImageResource(myDramasList.getDramaImage());
        holder.cardView.setBackgroundColor(Color.parseColor(myDramasList.getColor()));
        //Picasso.get().load(myDramasList.getDramaImage()).into(holder.dramasImage);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               /* Intent intent = new Intent(view.getContext(), MainActivity2.class);
                intent.putExtra("Name", myDramasList.getDramasName());
                intent.putExtra("Date", myDramasList.getDramasData());
                intent.putExtra("img", myDramasList.getDramaImage());
                context.startActivity(intent);
                // intent.putExtra("Image",myDramasList.getDramaImage());
          Picasso.get().load(myDramasList.getDramaImage() ).into(holder.dramasImage);
          view.getContext().startActivity(intent);*/

         /* YoYo.with(Techniques.Flash)
                  .duration(500)
                  .repeat(3)
                  .playOn(holder.itemView);
                setAnimations(holder.itemView,position);*/
                Dialog dialog=new Dialog(context);
                dialog.setContentView(R.layout.dialogbox);
                EditText editName=dialog.findViewById(R.id.etname);
                EditText editDept=dialog.findViewById(R.id.etdept);
                TextView textViewAdd=dialog.findViewById(R.id.tvadd);
                Button btnAdd=dialog.findViewById(R.id.btnAdd);
                 btnAdd.setText("Update");
                 textViewAdd.setText("Update Record");
                 editName.setText(myDramasList.getDramasName());
                 editDept.setText(myDramasList.getDramasData());
                btnAdd.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String name="";
                        String dept="";
                        if (editName.getText().toString().equals("")){
                            Toast.makeText(context, "file edit text", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            name=editName.getText().toString();
                        }
                        if (editDept.getText().toString().equals("")){
                            Toast.makeText(context, "file edit text", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            dept=editDept.getText().toString();
                        }
                        List.add(new MyDramasData(name,dept,R.drawable.dobol,"#4CAF50"));
                        notifyItemChanged(position);
                        dialog.dismiss();
                    }
                });
                dialog.show();

            }
        });
             holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                 @Override
                 public boolean onLongClick(View v) {

                     AlertDialog.Builder alertdialog=new AlertDialog.Builder(context).
                             setTitle("Alert Message").
                             setMessage("Are You sure you want to delete").
                            setIcon(R.drawable.ic_del).
                             setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                 @Override
                                 public void onClick(DialogInterface dialogInterface, int i) {
                                   List.remove(position);
                                   notifyItemRemoved(position);
                                 }
                             }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                                 @Override
                                 public void onClick(DialogInterface dialogInterface, int i) {

                                 }
                             });
                     alertdialog.show();



                     return false;
                 }
             });



    }

    //animation on recycler view
  /* private void setAnimations(View view ,int position)
       {
           Animation myanim= AnimationUtils.loadAnimation(context, android.R.anim.fade_out);
           view.setAnimation(myanim);
       }*/
    @Override
    public int getItemCount() {
        return List.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView dramasImage;
        TextView textViewName;
        TextView textViewDate;
        LinearLayout linearLayout;
        CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            dramasImage = itemView.findViewById(R.id.imageview);
            textViewName = itemView.findViewById(R.id.txtName);
            textViewDate = itemView.findViewById(R.id.txtdate);
            linearLayout=itemView.findViewById(R.id.linearlayout);
            cardView=itemView.findViewById(R.id.cardview);

        }
    }
}