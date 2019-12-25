package com.example.testpro;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class BookmarksAdapter extends RecyclerView.Adapter<BookmarksAdapter.Viewholder> {

    private List<QuestionModel> list;

    public BookmarksAdapter(List<QuestionModel> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bookmark_item,parent,false);

        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        holder.setData(list.get(position).getQuestion(),list.get(position).getOptionA(),list.get(position).getOptionB(),list.get(position).getOptionC(),list.get(position).getOptionD(),position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Viewholder extends RecyclerView.ViewHolder{

        private ImageButton deleteBtn;

        private TextView question,answer,a,b,c,d;

        public Viewholder(@NonNull View itemView) {
            super(itemView);


            a = itemView.findViewById(R.id.a);
            b = itemView.findViewById(R.id.b);
            c = itemView.findViewById(R.id.c);
            d = itemView.findViewById(R.id.d);

            question = itemView.findViewById(R.id.question);
            deleteBtn = itemView.findViewById(R.id.delete_btn);
        }

        private void setData(String question, String a, String b, String c, String d, final int position){
            this.a.setText("A) "+a);
            this.b.setText("B) "+b);
            this.c.setText("C) "+c);
            this.d.setText("D) "+d);
            this.question.setText("Вопрос: "+question);

            deleteBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    list.remove(position);
                    notifyItemRemoved(position);
                }
            });
        }
    }
}
