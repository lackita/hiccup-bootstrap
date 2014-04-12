(ns hiccup.bootstrap.components
  (:require clojure.string))

(defn navbar-collapse-id [header]
  (str header "-navbar-collapse"))

(defn navbar-body [header items]
  [:div {:class "collapse navbar-collapse"
         :id (navbar-collapse-id header)}
   [:ul {:class "nav navbar-nav"}
    [:li (first items)]]])
  

(defn navbar-header [header]
  [:div {:class "navbar-header"}
   [:button {:class "navbar-toggle"
             :data-toggle "collapse"
             :data-target (str "#" (navbar-collapse-id header))}
    [:span {:class "sr-only"} "Toggle navigation"]
    [:span {:class "icon-bar"}]
    [:span {:class "icon-bar"}]
    [:span {:class "icon-bar"}]]
   [:a {:class "navbar-brand" :href "#"} header]])

(defn navbar-wrapper [& contents]
  [:nav {:class "navbar navbar-default" :role "navigation"}
   (concat [:div {:class "container"}] contents)])

(defn navbar [args]
  (navbar-wrapper
   (navbar-header (:header args))
   (navbar-body (:header args) (:items args))))

