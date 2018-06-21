package jrml.supinternet.com.jeredecouvremalangue.singleWordFeature;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import jrml.supinternet.com.jeredecouvremalangue.R;

public class CitationAdapter extends RecyclerView.Adapter<CitationAdapter.ViewHolder> {
    private String[] mDataset;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView citationText;
        public ViewHolder(View v) {
            super(v);
            citationText = (TextView)v.findViewById(R.id.citationText);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public CitationAdapter(String[] myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public CitationAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.my_citation_view, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.citationText.setText("● "+mDataset[position]);

        // implement setOnClickListener event on item view.
        /*holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // display a toast with person name on item click
                clickListener.handle(view, mDataset[position]);
            }
        });*/

//        int resId = R.anim.item_animation_fall_down;
//        Animation animation = AnimationUtils.loadAnimation(holder.itemView.getContext(), resId);
//        holder.itemView.setAnimation(animation);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.length;
    }

    public interface OnViewClickedListener{
        public void handle(View view, String clickedElemData);
    }
    //créer interface
}
