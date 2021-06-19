package com.example.dinein.models


data class  ProductDetails (

    var item: ProductdetailsBean? = null,
    var related: List<Related>? = null,
    var cat: Int = 0,
    var subcat: Int = 0)




  data  class ProductdetailsBean (
        var id: Int = 0,
        var subcat_id: Int = 0,
        var name: String? = null,
        var name_en: String? = null,
        var img: String? = null,
        var description: String? = null,
        var description_en: String? = null,
        var total_rating: List<TotalRatingBean>? = null,
        var productphotos: List<ProductphotosBean>? = null,
        var offers: List<OffersBean>? = null,
        var favourites: List<FavouritesBean>? = null
    )
        //val product_colors: List<ProductColor>,




        class OffersBean {
            /**
             * id : 4
             * percentage : 30
             * product_id : 31
             */

            var id: Int = 0
            var percentage: Int = 0
            var product_id: Int = 0
        }

        class FavouritesBean {
            /**
             * product_id : 31
             * id : 1
             * user_id : 2
             */

            var product_id: Int = 0
            var id: Int = 0
            var user_id: Int = 0

        }


    class Related {
        var cat_id: Int = 0
        var id: Int = 0
        var name: String? = null
        var name_en: String? = null
        var img: String? = null
        var description: String? = null
        var description_en: String? = null
        var store_id: Int = 0


        var total_rating: List<TotalRatingBean>? = null
        var productphotos: List<ProductphotosBean>? = null


    }


