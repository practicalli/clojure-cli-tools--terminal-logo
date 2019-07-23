(ns hello-clojure
  (:require clansi
            [clojure.java.io :as io]))

(def styles
  {\b :bg-blue
   \g :bg-green
   \w :bg-white})

(defn colorize-line [line]
  (->> line
       (map #(clansi/style "  " (get styles % :bg-default)))
       (apply str)))

(defn -main []
  (with-open [r (io/reader (io/resource "logo.dat"))]
    (run! #(println (colorize-line %)) (line-seq r))))
